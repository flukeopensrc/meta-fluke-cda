SUMMARY = "Meta package for building an installable Fluke CDA toolchain and SDK"
LICENSE = "CLOSED"

inherit populate_sdk populate_sdk_qt5

TOOLCHAIN_HOST_TASK_append = " nativesdk-packagegroup-fluke-cda-toolchain-host"
TOOLCHAIN_TARGET_TASK_append = " packagegroup-fluke-cda-common"

TOOLCHAIN_TARGET_TASK_append_fluke-cda-nighthawk = " packagegroup-fluke-nighthawk"
