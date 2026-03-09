FROM node:18 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build --prod

FROM nginx:1.25
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist/angular/browser /usr/share/nginx/html
EXPOSE 80
