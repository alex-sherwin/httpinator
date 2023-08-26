/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}"],
  safelist: [
    { pattern: /.*/ },
  ],
  theme: {

    extend: {
      fontFamily: {
        sans: [
          "Inter var, sans-serif",
          {
            fontFeatureSettings: '"zero", "tnum", "cv11", "cv05", "ss01"',
            fontVariationSettings: '"opsz" 32'
          },
        ],
      }
    },
  },
  plugins: [],
}