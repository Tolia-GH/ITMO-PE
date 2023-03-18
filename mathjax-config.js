window.MathJax = {
    tex: {
      inlineMath: [['$', '$'], ['\\(', '\\)']],
    },
    chtml:{
        scale:0.8
    }
};
   
(function () {
    var script = document.createElement('script');
    script.src = 'https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-chtml.js';
    script.async = true;
    document.head.appendChild(script);
})();