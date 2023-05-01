
require recipes-images/angstrom/fluke-full-image.bb

IMAGE_FEATURES += " \
    debug-tweaks \
"

IMAGE_INSTALL_append = " packagegroup-fluke-cda-common-debug "

IMAGE_INSTALL_append_fluke-cda-nighthawk = " packagegroup-fluke-nighthawk-debug "

export IMAGE_BASENAME = "fluke-debug-image"