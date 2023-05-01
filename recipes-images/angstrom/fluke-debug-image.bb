
require recipes-images/angstrom/fluke-full-image.bb

EXTRA_IMAGE_FEATURES = " \
    debug-tweaks \
    tools-debug \
    tools-profile \
"

IMAGE_INSTALL_append = " packagegroup-fluke-cda-common-debug "

IMAGE_INSTALL_append_fluke-cda-nighthawk = " packagegroup-fluke-nighthawk-debug "