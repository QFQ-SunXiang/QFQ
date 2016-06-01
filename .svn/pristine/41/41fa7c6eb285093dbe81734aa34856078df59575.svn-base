#!/bin/sh

# bak database
echo "=================================== bak database start ==================================="
mysqldump -uroot -pQinfenqi@2015 qfq | gzip > /data/qfq_`date +%Y-%m-%d`.tar.gz
scp /data/qfq_`date +%Y-%m-%d`.tar.gz root@10.51.75.70:/data/mysql/
rm -rf /data/qfq_`date +%Y-%m-%d`.tar.gz
echo "=================================== bak database stop ==================================="

# bak images
echo "=================================== bak images start ==================================="
tar -czf /data/images_`date +%Y-%m-%d`.tar.gz /data/apache-tomcat-7.0.62/webapps/images/
scp /data/images_`date +%Y-%m-%d`.tar.gz root@10.51.75.70:/data/images/
rm -rf /data/images_`date +%Y-%m-%d`.tar.gz
echo "=================================== bak images stop ==================================="

