#!/bin/bash

function create_default_app_env() {
cat > .env <<EOF
DATABASE_URI=to-be-defined
APPLICATION_NAME=$1$1
APPLICATION_CODE_VERSION=0.1.0
SERVER_PORT=8081
APPLICATION_DESCRIPTION=$1API
APPLICATION_VERSION=v1
CONTACT_NAME=Fabricio-Nogueira
CONTACT_SITE=http://fabricionogueira.me
CONTACT_EMAIL=nogsantos@gmail.com
TWITTER_CONF_LIMIT_COUNTER=10
TWITTER_CONF_DEFAULT_LANG=pt
twitter4j.oauth.consumerKey=to-be-defined
twitter4j.oauth.consumerSecret=to-be-defined
twitter4j.oauth.accessToken=to-be-defined
twitter4j.oauth.accessTokenSecret=to-be-defined
twitter4j.debug=true
EOF
	printf ".env file created. \n\n"
}
