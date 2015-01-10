= Kernels and Bootloaders =

The default kernels and bootloaders are not to be installed by debootstrap,
and *-minimal metapackages should not depend on them; however, they do need
to end up on CD images and in live filesystems. We therefore put them in a
separate seed.

We seed both linux-* and linux-image-* so that it's easier to build CD
images without the restricted component. The linux-* kernels include
restricted modules.

 * Kernel-Stem: linux linux-image

== i386 ==

 * grub [amd64 i386]                      # lilo will be in supported
 * grub-pc [amd64 i386]
 * ${Kernel-Stem}-generic-lts-utopic [i386]          # our chosen default install kernel

== powerpc ==

 * yaboot [powerpc]
 * ${Kernel-Stem}-powerpc-smp-lts-utopic [powerpc]   # powerpc kernel, 32-bit machines
 * ${Kernel-Stem}-powerpc64-smp-lts-utopic [powerpc] # powerpc kernel, 64-bit machines

== ppc64el ==

 * grub-ieee1275 [ppc64el]
 * ${Kernel-Stem}-generic-lts-utopic [ppc64el]       # default install kernel for ppc64el

== amd64 ==

 * ${Kernel-Stem}-generic-lts-utopic [amd64]         # amd64 kernel, works on all machines though not optimised

== armel / armhf ==

 * ${Kernel-Stem}-generic-lts-utopic [armhf]         # multiplatform kernel, will eventually replace others
 * ${Kernel-Stem}-dove [armel]
 * ${Kernel-Stem}-omap [armel armhf]
 * ${Kernel-Stem}-linaro-vexpress [armel]
 * ${Kernel-Stem}-linaro-omap [armel]
 * ${Kernel-Stem}-armadaxp [armhf]
 * ${Kernel-Stem}-highbank [armhf]

== arm64 ==

 * grub-efi-arm64 [arm64]
 * ${Kernel-Stem}-generic-lts-utopic [arm64]

== Germinate workarounds ==

Stop grub-common -> base-files -> awk from selecting mawk. (Since the boot seed doesn't inherit from required for arcane reasons, this is the only way we can make this work reliably ...)

 * mawk
