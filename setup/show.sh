#!/bin/bash

function print_created_env_values() {
	printf "Environment values: \n\n"
	echo DATABASE_URI=$DATABASE_URI
    echo APPLICATION_NAME=$APPLICATION_NAME
    echo APPLICATION_CODE_VERSION=$APPLICATION_CODE_VERSION
    echo SERVER_PORT=$SERVER_PORT
    echo APPLICATION_DESCRIPTION=$APPLICATION_DESCRIPTION
    echo APPLICATION_VERSION=$APPLICATION_VERSION
    echo CONTACT_NAME=$CONTACT_NAME
    echo CONTACT_SITE=$CONTACT_SITE
    echo CONTACT_EMAIL=$CONTACT_EMAIL
    echo TWITTER_CONF_LIMIT_COUNTER=$TWITTER_CONF_LIMIT_COUNTER
    echo TWITTER_CONF_DEFAULT_LANG=$TWITTER_CONF_DEFAULT_LANG
    echo twitter4j.oauth.consumerKey=to-be-defined
    echo twitter4j.oauth.consumerSecret=to-be-defined
    echo twitter4j.oauth.accessToken=to-be-defined
    echo twitter4j.oauth.accessTokenSecret=to-be-defined
    echo twitter4j.debug=true
}
