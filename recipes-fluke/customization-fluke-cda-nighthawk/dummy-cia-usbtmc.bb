SUMMARY = "Dummy usbtmc recipe to generate license package"
DESCRIPTION = "Dummy usbtmc recipe."
AUTHOR = "Tektronix"
#SECTION = "base"
HOMEPAGE = ""

PACKAGES = "${PN}"

LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://usbtmc/COPYING.LESSER;md5=3000208d539ec061b899bce1d9ce9404 \
"

SRC_URI = "git://github.com/flukeopensrc/cia-sw-thirdparty.git;protocol=git;branch=develop"

SRCREV ?= "${AUTOREV}"

FILES_${PN} += " \
"

S = "${WORKDIR}/git"

#FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = "\
"

do_compile[noexec] = "1"

do_clean[noexec] = "1"

do_install () {
}

RPROVIDES_${PN} += "${PN}-lic"

