#!/bin/sh
ROOT_DIRECTORY=`pwd` 

SBT_VERSION="0.13.13"
SBT_BIN_PATH_FROM_ARCHIVE="sbt-launcher-packaging-0.13.13/bin/sbt"

SBT_TARGET_CONTAINER="$ROOT_DIRECTORY/target/sbt"


SBT_FILE="sbt-$SBT_VERSION.tgz"
SBT_FILE_CHECKSUM="$SBT_FILE.md5"

# If sbt has not been installed yet
if [ -f $SBT_TARGET_CONTAINER/$SBT_BIN_PATH_FROM_ARCHIVE ]; then
	echo "=== Expected version of sbt launcher ($SBT_VERSION) already available. Use it ==="
	
else
	# Remove any older installation
	rm -fr $SBT_TARGET_CONTAINER	
    echo "=== DOWNLOAD and INSTALL SBT Launcher (none detected) ==="
    cd /tmp 
    echo ""
    echo "= Download the launcher ="
    curl -LO --max-redirs 2 https://dl.bintray.com/sbt/native-packages/sbt/$SBT_VERSION/$SBT_FILE 
     
    echo ""
    echo "= Download the MD5 of the launcher ="
    curl -LO --max-redirs 2 https://dl.bintray.com/sbt/native-packages/sbt/$SBT_VERSION/$SBT_FILE_CHECKSUM 
    echo " $SBT_FILE" >> $SBT_FILE_CHECKSUM
 
    echo ""
    echo "= Verifying integrity ="
    md5sum --quiet -c $SBT_FILE_CHECKSUM

    md5_check_result=$?

    if [ $md5_check_result != 0 ]; then
        echo "Oh no!!!! Integrity check failed!"
        exit 1
    fi
	rm -f $SBT_FILE_CHECKSUM
	
    echo ""
    echo "= Extracting locally ="
    cd $ROOT_DIRECTORY
    mkdir -p $SBT_TARGET_CONTAINER
	tar -xzf /tmp/$SBT_FILE -C $SBT_TARGET_CONTAINER    
    rm -f /tmp/$SBT_FILE   
fi

# Then start sbt
cd $ROOT_DIRECTORY
$SBT_TARGET_CONTAINER/$SBT_BIN_PATH_FROM_ARCHIVE $@



