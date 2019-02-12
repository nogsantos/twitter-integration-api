#!/bin/bash

#include lib
.  setup/check.sh
.  setup/create.sh
.  setup/export.sh
.  setup/show.sh

check_env_in_project

create_default_app_env "twitter-integration"

export_env_to_session

print_created_env_values
