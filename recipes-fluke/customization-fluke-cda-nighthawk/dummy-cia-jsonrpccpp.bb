SUMMARY = "Dummy jsonrpccpp recipe to generate license package"
DESCRIPTION = "Dummy jsonrpccpp recipe."
AUTHOR = "git://github.com/cinemast/libjson-rpc-cpp"
#SECTION = "base"
HOMEPAGE = ""

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://jsonrpccpp/LICENSE.txt;md5=4e728c5b36018f6c383b4b9efd9c8840 \
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
