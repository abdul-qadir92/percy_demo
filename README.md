#percy_demo commands to run the test

export PERCY_TOKEN = token for percy project

##to build base branch

PERCY_BRANCH=prod npx percy exec -- mvn test -P prod

##to run the compare the staging url from prod

PERCY_BRANCH=stage  PERCY_TARGET_BRANCH=prod npx percy exec -- mvn test -P stage
