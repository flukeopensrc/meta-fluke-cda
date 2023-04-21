SUMMARY = "Fluke CDA customization for Blackhawk"
DESCRIPTION = "Blackhawk application, etc."
AUTHOR = "Fluke"
SECTION = ""
HOMEPAGE = ""

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae270d4118d7e64218492af5b3f3249b"

#PR = "r0"

#fontconfig, freetype, libpng, libcrypto (provided by openssl) used by "/home/Blackhawk/bin/update" executable
#linux-gpib-user used by "/home/Blackhawk/bin/remoteapp" executable
#qtbase, qtdeclarative, qtquickcontrols2-qmlplugins used by "/home/Blackhawk/bin/fp" executable
DEPENDS = " \
	fontconfig \
	freetype \
	libpng \
	openssl \
	linux-gpib-user \
"
RDEPENDS_${PN} += " \
	systemd \
"

SRC_URI = "git://github.com/flukeopensrc/sumo-rootfs-extras.git;protocol=git;branch=master"

SRCREV ?= "${AUTOREV}"

FILES_${PN} += " \
	${base_prefix}/www/* \
	${base_prefix}/home/* \
	${base_prefix}/tmp/customization_data/* \
	${base_prefix}/config/ \
	${base_prefix}${systemd_system_unitdir} \
	${base_prefix}${sysconfdir}/systemd/system/multi-user.target.wants/ \
"

S = "${WORKDIR}/git"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = "\
	file://instrument.service \
	file://launchApp.service \
	file://extra_files/ \
"

do_compile[noexec] = "1"

do_clean[noexec] = "1"

do_install () {
	(
		cd ${S}/common/extraFiles/target_root/ &&
			find -type f -exec sh -c 'install -D -m $(stat -c "%a" "$1") "$1" ${D}/"$1"' sh \{\} \;
	)
	(
		cd ${S}/Blackhawk/extraFiles/target_root/ &&
			find -type f -exec sh -c 'install -D -m $(stat -c "%a" "$1") "$1" ${D}/"$1"' sh \{\} \;
	)
	#fixup ssh dir permissions
	chmod 700 ${D}${ROOT_HOME}/.ssh
	install -d ${D}/home/Test
	install -d ${D}/home/Proto
	install -d ${D}/config

	#install systemd services for starting instrument app
	install -d ${D}${systemd_system_unitdir}
	install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
	install -m 644 ${WORKDIR}/instrument.service ${D}${systemd_system_unitdir}/
	#launchApp.service is moving to the nighthawk-sw-src repo, so can be removed in the future
	install -m 644 ${WORKDIR}/launchApp.service ${D}${systemd_system_unitdir}/
	install -d ${D}${sbindir}
	install -m 755 ${WORKDIR}/extra_files/doDtreeOverlay ${D}${sbindir}/
	ln -sr ${D}${systemd_system_unitdir}/instrument.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
	ln -sr ${D}${systemd_system_unitdir}/launchApp.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/

	#auto-load kernel modules needed for serial gadget
	install -d ${D}${sysconfdir}/modules-load.d
	install -m 644 ${WORKDIR}/extra_files/fluke_gadgets.conf ${D}${sysconfdir}/modules-load.d/
}