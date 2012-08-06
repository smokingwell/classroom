#!/bin/bash
#to install some common useful software after fedora 10 installed
### *ONLY* run in root mode###
#add rmpfusion repositories for yum
#default f
if [[ "`uname -a`" == *Ubuntu* ]] ; then
	INSTALL_CMD="apt-get -y install"
	GVIM="vim-gnome vim-gtk"
elif [[ "`uname -a`" == *fc* ]] ; then  
	INSTALL_CMD="yum -y install"
	GVIM=gvim
fi
echo "install command:$INSTALL_CMD"
return

rpm -ivh http://download1.rpmfusion.org/free/fedora/rpmfusion-free-release-stable.noarch.rpm
rpm -ivh http://download1.rpmfusion.org/nonfree/fedora/rpmfusion-nonfree-release-stable.noarch.rpm
rpm --import /etc/pki/rpm-gpg/RPM-GPG-KEY-rpmfusion-*

#basic tools
$INSTALL_CMD gnochm xchat thunderbird krusader xxdiff krename evince $GVIM unrar stardict xterm gconf-editor vpnc meld wine freemind colordiff goldendict p7zip

#for firefox, todo more
rpm -ivh http://linuxdownload.adobe.com/linux/i386/adobe-release-i386-1.0-1.noarch.rpm
$INSTALL_CMD flash-plugin

#input methord
# create a symbolic link to /etc/X11/xinit/xinput.d/scim with name as xinput-YOUR LOCALE under /etc/alternatives. e.g. xinput-en_US
# add "scim -d" to any of your startup script, e.g. xsession, .bashrc, .bash_profile
$INSTALL_CMD scim-pinyin

#multimedia & video codec & others
#$INSTALL_CMD filezilla k3b gparted nautilus-open-terminal gftp gallery2-picasa 
#$INSTALL_CMD ffmpeg ffmpeg-libs gstreamer-ffmpeg libmatrosca xvidcore
#$INSTALL_CMD mplayer smplayer

