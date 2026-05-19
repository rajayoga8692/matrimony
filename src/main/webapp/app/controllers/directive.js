    
angular.module("directiveads",[]).directive('ads', function() {
    return {
        restrict: 'A',
        templateUrl: 'views/adsTpl',
        controller: function(){
            (adsbygoogle = window.adsbygoogle || []).push({});
        }
    };
});