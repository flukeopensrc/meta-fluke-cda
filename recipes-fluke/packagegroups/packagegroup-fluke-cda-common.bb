
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