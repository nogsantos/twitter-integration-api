#!/bin/bash

function create_default_app_env() {
cat > .env <<EOF
DATABASE_URI=to-be-defined
APPLICATION_NAME=$1
APPLICATION_CODE_VERSION=0.1.0
SERVER_PORT=8081
APPLICATION_DESCRIPTION=$1 API
APPLICATION_VERSION=v1
CONTACT_NAME="Fabricio Nogueira"
CONTACT_SITE=http://fabricionogueira.me
CONTACT_EMAIL=nogsantos@gmail.com
TWITTER_CONSUMER_KEY=to-be-defined
TWITTER_CONSUMER_SECRET=to-be-defined
TWITTER_ACCESS_TOKEN=to-be-defined
TWITTER_ACCESS_TOKEN_SECRET=to-be-defined
EOF
	printf ".env file created. \n\n"
}
