// Use this file for any Webpack configuration you want to apply to all environments.
const path = require("path");

module.exports ={
    resolve: {
        modules: [
            path.resolve("src/main/resources")
        ]
    }
};
