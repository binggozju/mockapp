#!/bin/bash
# --------------------------------------------------
# Usage: used to test each api of mockapp
# --------------------------------------------------

HOST=http://localhost:9754

curl -X POST -H "Accept: application/json" -H "Content-type: application/json" -d "{}" $HOST/toy/add 2> /dev/null
exit

# ----------- test /city ------------
# insert
#curl -X POST -H "Accept: application/json" -H "Content-type: application/json" -d "{\"name\": \"Shaoxing\", \"province\": \"ZheJiang\"}" $HOST/city 2> /dev/null
#curl -X POST -H "Accept: application/json" -H "Content-type: application/json" -d "{\"name\": \"Nanjing\", \"province\": \"JiangSu\"}" $HOST/city 2> /dev/null
#curl -X POST -H "Accept: application/json" -H "Content-type: application/json" -d "{\"name\": \"Hefei\", \"province\": \"AnHui\"}" $HOST/city 2> /dev/null

# select
#curl -X GET -H "Accept: application/json" $HOST/city/1 2> /dev/null
#curl -X POST -H "Accept: application/json" -H "Content-type: application/json" -d "{\"pageNum\": 2, \"pageSize\": 3}" $HOST/city/list 2> /dev/null

# update
#curl -X PUT -H "Accept: application/json" -H "Content-type: application/json" $HOST/city/1 -d "{\"name\": \"Fuzhou\", \"province\": \"FuJian\"}" 2> /dev/null
#curl -X PUT -H "Accept: application/json" -H "Content-type: application/json" $HOST/city/1 -d "{\"province\": \"GuangDong\"}" 2> /dev/null

# delete
#curl -X DELETE -H "Accept: application/json" $HOST/city/1 2> /dev/null

# ----------- test /person ----------
# insert
#curl -X POST -H "Accept: application/json" -H "Content-type: application/json" -d "{\"name\": \"Angle\", \"phone\": \"123456\", \"cityId\": 2}" $HOST/person 2> /dev/null
#curl -X POST -H "Accept: application/json" -H "Content-type: application/json" -d "{\"name\": \"Binggo\", \"phone\": \"786598\", \"cityId\": 3}" $HOST/person 2> /dev/null
#curl -X POST -H "Accept: application/json" -H "Content-type: application/json" -d "{\"name\": \"John\", \"phone\": \"120983\"}" $HOST/person 2> /dev/null

# join select
#curl -X GET  -H "Accept: application/json" -H "Content-type: application/json" -d "{\"pageNum\": 2, \"pageSize\": 3}" $HOST/person/list 2> /dev/null

