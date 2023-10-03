const name = document.getElementById('name')
const profession = document.getElementById('profession')

function wordLength(word) {
    const num = word.textContent.length
    word.setAttribute('style' , '--typewriterCharacters:'+ num + ' ')
}
wordLength(name)
wordLength(profession)

$(document).ready(function(){
    $.fn.animate_Text = function() {
        var string = this.text();
        return this.each(function(){
            var $this = $(this);
            $this.html(string.replace(/./g, '<span class="new">$&</span>'));
            $this.find('span.new').each(function(i, el){
                setTimeout(function(){ $(el).addClass('div_opacity'); }, 20 * i);
            });
        });
    };
    setTimeout(function() {
        $('#smooth-effect').show();
        $('#smooth-effect').animate_Text();
    }, 5500);
});



