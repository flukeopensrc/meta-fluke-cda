PR = "r12"
SRC_URI = "git://github.com/flukeopensrc/u-boot-fluke-cda.git;protocol=git;branch=v2016.11-fluke-cda"
SRCREV = "${AUTOREV}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

#SRC_URI_append_fluke-cda-vanquish = "\
#	file://0001-Add-Fluke-CDA-Vanquish-board-to-uboot.patch \
#"
