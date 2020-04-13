FROM ubuntu:16.04

RUN apt-get update && apt-get install -y nginx && apt-get install -y apt-utils && apt-get install -y openssl

RUN openssl req -newkey rsa:4096 -x509 -sha256 -days 365 -nodes -out server.crt -keyout server.key -subj "/C=IN/ST=Karnataka/L=Bangalore/O=Security/OU=Devops Department/CN=$HOSTNAME"

COPY index.html /usr/share/nginx/html/

EXPOSE 80

EXPOSE 443

CMD ["nginx", "-g", "daemon off;"]
