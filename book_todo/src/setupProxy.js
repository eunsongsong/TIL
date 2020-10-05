const { createProxyMiddleware } = require("http-proxy-middleware");
module.exports = function (app) {
  app.use(
    "/api/books",
    createProxyMiddleware({
      target: "http://localhost:9000/",
      changeOrigin: true,
    })
  );
  app.use(
    "/api/todos",
    createProxyMiddleware({
      target: "http://localhost:9001/",
      changeOrigin: true,
    })
  );
};

// "proxy": {
//     "/api/books": {
//       "target": "http://localhost:9000"
//     },
//     "/api/todos": {
//       "target": "http://localhost:9001"
//     }
//   },
