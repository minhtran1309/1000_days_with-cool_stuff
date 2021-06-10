Run the following command in order

(1) `diskutil unmountDisk /dev/disk2`

(2) `diskutil eject /dev/disk2`

If the error occurs in step 2:
Volume timed out while waiting to eject


Solution:

`ps aux | grep fsck`
(output should lood like this) 

root             41601   1.4  0.1  4331492  20600   ??  U    10:34am   0:31.36 /System/Library/Filesystems/exfat.fs/Contents/Resources/./fsck_exfat -y /dev/rdisk2s2

uqmtra12         41637   0.0  0.0  4278288    828 s001  S+   10:35am   0:00.00 grep fsck

`sudo kill 41601` (replace the id accordingly)

rerun step 2, unplug the hard drive and plug again
