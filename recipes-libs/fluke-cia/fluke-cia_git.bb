SUMMARY = "Fluke CIA"
DESCRIPTION = "Fluke Common Instrument Architecture"
HOMEPAGE = "https://https://github.com/FlukeCorp/cia-sw-src"
SECTION = "libs"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/extra_files/LICENSE;md5=fce4b53e0185d2bc7e836efefa539090"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "freetype \
	libpng \
	openssl \
	fontconfig \
	linux-gpib-user \
	sqlite3 \
"

SRC_URI = "git://github.com/FlukeCorp/cia-sw-src.git;protocol=https;branch=fmhess-develop;destsuffix=git/cia/src;name=ciasrc \
	git://github.com/FlukeCorp/cia-sw-utils.git;protocol=https;branch=develop;destsuffix=git/cia/utils;name=ciautils \
	git://github.com/FlukeCorp/cia-sw-thirdparty.git;protocol=https;branch=develop;destsuffix=git/cia/thirdparty;name=ciathirdparty \
	file://extra_files/LICENSE \
	file://git/CMakeLists.txt \
	file://git/cia/CMakeLists.txt \
"
SRCREV_FORMAT = "ciasrc_ciautils_ciathirdparty"
SRCREV ?= "${AUTOREV}"
PV = "git_${SRCREV}"
PR = "r0"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += " \
"

FILES_${PN} += " \
"