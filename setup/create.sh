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
EOF
	printf ".env file created. \n\n"
}
