SUMMARY = "Linux-GPIB kernel modules"
DESCRIPTION = "https://linux-gpib.sourceforge.io/"
HOMEPAGE = "https://linux-gpib.sourceforge.io/"
BUGTRACKER = "https://sourceforge.net/p/linux-gpib/bugs/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

SRCREV = "1914"
PV = "svnr${SRCREV}"
PR = "r0"

# The `make-install-depmod.patch` is really just for docker builds, otherwise
# depmod will pull the host(the container) kernel version instead of yocto build.
# Even so it doesn't look like we even need the output of depmod.
SRC_URI = "svn://svn.code.sf.net/p/linux-gpib/code/;module=trunk/linux-gpib-kernel;protocol=https;rev=${SRCREV} \
file://make-install-depmod.patch"

S = "${WORKDIR}/trunk/linux-gpib-kernel"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

RPROVIDES_${PN} += "linux-gpib"

EXTRA_OEMAKE += "LINUX_SRCDIR=${STAGING_KERNEL_DIR} BASE_PATH=${D} KERNEL_VERSION=${KERNEL_VERSION}"

MODULES_INSTALL_TARGET = "install"
MODULES_MODULE_SYMVERS_LOCATION = "drivers/gpib/"
