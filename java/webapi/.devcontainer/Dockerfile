ARG VARIANT=17-bullseye
FROM mcr.microsoft.com/devcontainers/java:${VARIANT}

RUN apt-get update \
    && apt-get -y install --no-install-recommends \
    # Network util
    inetutils-ping

#ARG GRADLE_VERSION=""
#RUN su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install gradle \"${GRADLE_VERSION}\""
