FROM tomcat:latest
ADD /build/libs/ /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh","run"]