
DESCRIPTION = "Common packages for CDA projects"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = " \
    ${PN}-base \
    ${PN}-console \
    ${PN}-sdk \
    ${PN}-debug \
    ${PN} \
"

RDEPENDS_${PN} = "\
    ${PN}-base \
"
# Additional packages to the fluke-full image
RDEPENDS_${PN}-base = " \
"

# Packages common to the fluke-console image
RDEPENDS_${PN}-console = " \
    avahi-daemon avahi-autoipd \
    fontconfig \
    fontconfig-utils \
    freetype \
    iproute2 \
    kernel-module-fluke-gpib \
    kernel-module-fmh-gpib \
    kernel-module-gpio-fluke \
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
# Debug Image
RDEPENDS_${PN}-debug = " \
    googletest \
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