
PR = "r2"
KERNEL_REPO = "git://github.com/flukeopensrc/linux-socfpga.git"

LINUX_VERSION = "5.4.13"
LINUX_VERSION_SUFFIX = "-lts-fluke-cda"
SRCREV = "${AUTOREV}"

KERNEL_DEVICETREE_fluke-cda-vanquish = "Vanquish_soc.dtb Vanquish_soc_overlay.dtb"
KERNEL_DEVICETREE_fluke-cda-richmond = "Richmond_005.dtb Richmond_005_overlay.dtb"
KERNEL_DEVICETREE_fluke-cda-triclamp = "Triclamp_soc.dtb Triclamp_soc_overlay.dtb"
KERNEL_DEVICETREE_fluke-cda-nighthawk = "Nighthawk_soc.dtb Nighthawk_soc_overlay.dtb"
KERNEL_DEVICETREE_fluke-cda-caldera = "Caldera_soc.dtb Caldera_soc_overlay.dtb"
KERNEL_DEVICETREE_fluke-cda-blackhawk = "Blackhawk_soc.dtb Blackhawk_soc_overlay.dtb"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "\
    file://fluke-cda.cfg \
    file://${MACHINE}.cfg \
"

#add kernel modules needed for iptables support to nighthawk
SRC_URI_append_fluke-cda-nighthawk = "\
    file://netfilter.cfg \
"

do_fetch_prepend () {
    bb.warn("Old repo is still being used: ${KERNEL_REPO}")
}