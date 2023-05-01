
DESCRIPTION = "Common packages for CDA projects"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = " \
    ${PN}-image \
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
# Additional packages to install in fluke-full image
RDEPENDS_${PN}-full = " \
"

# Additional packages to install in Debug Image
RDEPENDS_${PN}-debug = " \
    googletest \
"

# Packages common to the fluke-console image
RDEPENDS_${PN}-console = " \
    avahi-daemon avahi-autoipd \
    fontconfig \
    fontconfig-utils \
    freetype \
    iproute2 \
    libgpiod \
    libgpiod-tools \
    libusb-compat \
    lighttpd \
    lighttpd-module-fastcgi \
    linux-gpib-user \
    mtd-utils \
    php-cli php-cgi php-fpm php-phar php \
    qtbase qtbase-tools qtbase-plugins \
    rt-tests \
    tslib tslib-tests \
    ttf-roboto \
    util-linux \
"

# Target toolchain
RDEPENDS_${PN}-sdk = " \
    freetype-dev \
    googletest-dev \
    googletest-staticdev \
    libeigen-dev \
    libgpiod-dev \
"

# TODO: move to seperate product packagegroup
RDEPENDS_${PN}_append_fluke-cda-vanquish = " \
    libnrp \
    librsnrpz \
"
RRECOMMENDS_${PN}_mingw32 = "\
    libssp \
    libssp-dev \
"