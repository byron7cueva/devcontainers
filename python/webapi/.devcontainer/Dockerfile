ARG VARIANT=13.8
FROM mcr.microsoft.com/devcontainers/python:${VARIANT}

RUN apt-get update && apt-get install -y --no-install-recommends \
    # Network util
    inetutils-ping

## Pip dependencies
# Upgrade pip
RUN pip install --upgrade pip