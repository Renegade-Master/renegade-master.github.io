// Use this file for any Webpack configuration you want to apply to all environments.
const path = require('path');

module.exports = {
    mode: 'development',
    // resolve: {
    //     modules: [
    //         path.resolve("src/jsMain/kotlin"),
    //         path.resolve("src/jsMain/resources")
    //     ]
    // }
    module: {
        rules: [
            {
                test: [/\bstrings\.properties$/],
                type: 'javascript/auto', // required by Webpack for JSON files
                loader: '@messageformat/loader',
                options: {locale: ['de', 'en', 'fr']}
            }
        ]
    }
};
