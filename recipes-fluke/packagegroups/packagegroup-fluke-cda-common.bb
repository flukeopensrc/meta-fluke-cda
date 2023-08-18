
DESCRIPTION = "Common packages for CDA projects"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = " \
    ${PN}-full \
    ${PN}-debug \
    ${PN}-console \
    ${PN}-sdk \
    ${PN} \
"

# Everything listed here will be included in SDK
RDEPENDS_${PN} = "\
    ${PN}-full \
    ${PN}-console \
    ${PN}-debug \
    ${PN}-sdk \
"
# Packages to install in fluke-full image
RDEPENDS_${PN}-full = " \
"

# Packages to install in Debug Image
RDEPENDS_${PN}-debug = " \
    googletest \
"

# Packages to install in fluke-console image
RDEPENDS_${PN}-console = " \
    fontconfig \
    freetype \
    libgpiod \
    libgpiod-tools \
    libusb-compat \
    linux-gpib-user \
    qtbase qtbase-tools qtbase-plugins \
    tslib tslib-tests \
    util-linux \
"

# Packages to include in the SDK only
RDEPENDS_${PN}-sdk = " \
    googletest-dev \
    googletest-staticdev \
    libgpiod-dev \
"

RRECOMMENDS_${PN}_mingw32 = "\
    libssp \
    libssp-dev \
"