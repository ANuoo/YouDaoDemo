
# 仿有道词典
##UI</br>
  主布局是MainActivity,其中为了实现页面的切换，我用了radiogroup，radiogoup中有五个radiobutton，并使用了selector为每个button设置了点击的图标切换，还
  为每个radiogroup设置了对应的fragment，当点击图标时，通给getId来切换fragment。
</br>
</br>
#fragment</br>
 每个fragment都采用了recycleview来展示竖向或横向的数据，其中用srcollview包含一个布局，使布局可滚动。MineFragment中应用了coordinator布局，使向上滚动时，能够
 通过调整text和image的alpha来实现隐藏。而登录的标题通过折叠字体大小进行改变，这是利用了behavior中已给的behavior的@string/appbar_scrolling_view_behavior
</br>
#广告页</br>
  splash页面的制作时由于加载主布局时需要一定的时间，而这段时间内屏幕会出现短时间的黑屏或白屏，为了能自然过渡，加入了splash。</br>
#功能</br>
  通过点击dictionary中的edittxt会切换到输入页面，并且在输入的内容通过网络请求可找到时，在该activity中返回内容，点击内容又可以进入单词界面，如果找不到会转到对应的界面</br>
  ![avater](http://m.qpic.cn/psb?/V12pRwMy1vBidC/CsUE1hi*Zck2joe8NuyUfdyzNxvetBf8ah0yyQO2PxI!/b/dDQBAAAAAAAA&bo=OASABwAAAAARF5s!&rf=viewer_4)
  ![avater](http://m.qpic.cn/psb?/V12pRwMy1vBidC/GY2Y3WY47Co*FEhPlAkOMCEmBfwMlQTEREd6tmwKJNA!/b/dLYAAAAAAAAA&bo=OASABwAAAAARF5s!&rf=viewer_4)
   ![avater](http://m.qpic.cn/psb?/V12pRwMy1vBidC/uxxTkVqUA8tSCo*Y6xvkqt8JylejcwH*QUwomm5.U2M!/b/dDABAAAAAAAA&bo=OASABwAAAAARF5s!&rf=viewer_4)
#体会</br>
  第一次使用有道词典，因为词典在不断的丰富，不断的改善，不仅仅是查词，相关英语的内容的推送，多语言的翻译实现。对于一些图片的处理还是有不足，没有适配，功能是后面赶的，后面的页面真的不好看。我会好好努力，虽然我如此之菜。
  

 
 
  