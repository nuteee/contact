# base image
FROM node:12.2.0 as builder

# install chrome for protractor tests
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
RUN apt-get update && apt-get install -yq google-chrome-stable

# set working directory
WORKDIR /contact-frontend

# add `/app/node_modules/.bin` to $PATH
ENV PATH /contact-frontend/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package*.json /contact-frontend/
RUN npm install
RUN npm install -g @angular/cli

# add app
COPY . /contact-frontend

RUN npm run ng build -- --prod --output-path=dist

FROM nginx:alpine

## Copy our default nginx config
COPY nginx/default.conf /etc/nginx/conf.d/

## Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*

## From ‘builder’ stage copy over the artifacts in dist folder to default nginx public folder
COPY --from=builder /contact-frontend/dist /usr/share/nginx/html

# expose port 80
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
