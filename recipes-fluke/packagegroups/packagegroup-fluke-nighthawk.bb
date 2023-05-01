
DESCRIPTION = "Nighthawk specific packages"
LICENSE = "CLOSED"

inherit packagegroup

PACKAGES = " \
    ${PN}-install-only \
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

# Install only but do not include in SDK
#add dummy packages for libraries provided via cia-sw-thirdparty, so that their license packages get installed
RDEPENDS_${PN}-install-only = " \
    dummy-cia-jsoncpp-lic \
    dummy-cia-jsonrpccpp-lic \
    dummy-cia-usbtmc-lic \
    fluke-cia-nighthawk \
    fluke-run-once \
    kernel-devicetree \
    noto-sans-cjk-light \
    noto-sans-hinted-light \
    rescue-fluke-cda-bootfiles \
"

#fontconfig, freetype, libpng, libcrypto (provided by openssl) used by "/home/Nighthawk/bin/update" executable
#linux-gpib-user used by "/home/Nighthawk/bin/remoteapp" executable
#qtbase, qtdeclarative, qtquickcontrols2-qmlplugins used by "/home/Nighthawk/bin/fp" executable

# Packages to be install on the image and sdk
RDEPENDS_${PN}-full = " \
    libeigen-lic \
    libpng \
    openssl \
    qtdeclarative \
    qtquickcontrols2-qmlplugins \
    systemd \
"

# Packages to be install on debug image
RDEPENDS_${PN}-debug = " \
"

# Packages to install in fluke-console image
RDEPENDS_${PN}-console = " \
    e2fsprogs \
"

# Packages to include in the SDK only
RDEPENDS_${PN}-sdk = " \
    libeigen-dev \
"

