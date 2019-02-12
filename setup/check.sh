#!/bin/bash

function check_env_in_project() {
	if [[ -e ".env" ]]; then
		rm .env
		printf "\n\nCurrent .env file deleted. \n\n"
	fi
}
