
/* jquery study~~~ */
$(document).ready(function(){
	$('#study').css('background','pink');
	$('#develop').css('background','yellow');
	$('#result').css('background','skyblue');
	//$('body ul #notice').hide();
	//var home = $('div ul');
	//home.find('#fCome').hide();
	//$('.tab-pane').hide();
	
	var imgAttr1 = $('.carousel-inner #img1');
	var imgAttr2 = $('.carousel-inner #img2');
	var imgAttr3 = $('.carousel-inner #img3');
	
	var studyPanel = $('#studyPanel');
    studyPanel.hide();
    
	
	//imgAttr1.width('1050px');
	//imgAttr1.height('350px');
	
	//imgAttr2.width('1050px');
	//imgAttr2.height('450px');
	
	//imgAttr3.width('1050px');
	//imgAttr3.height('550px');
	
	/* facebookLink */
	//$('#facebookLink').fadeIn();
	//$('#facebookLink').slideDown();
	$('#facebookLink').fadeIn();  // �������� ���̰�!
	
	
	var div1=$('#div1');
		
	div1.animate({
		top: 300,
		left: 300
		
	},1000);
	
	div1.slideUp(2000);  // �ִ����� �����!
	
	//$('#div1').text('����? NO!, ������? NO!!'); // �ؽ�Ʈ�� ��ü! html()�� �ִ�!
	//$('#div1').empty();  // div�� ���������� �ؽ�Ʈ�� �������.
	
	//$('.carousel-inner #attrTest').attr('src', 'resources/img/acet.png'); // ����� �Ӽ����� �����ϴ� �޼ҵ�!
	//$('#searchInput').val('�˻��� Ű���带 �־��ּ���!');
	var searchInput=$('#searchInput');
	searchInput.width('20em');
	
	/* <span class="label label-success">Step 01.</span> */
	//$('.label').removeClass('label-success'); // ���� ���� �������� class�� ��� ����! addClass()�� ����!

	/***** EVENT ******/
	// click
	var searchBtn = $('#searchBtn');
	searchBtn.click(function(){
		var searchKeyword = $('#searchInput');
		alert("click �Ǿ����ϴ�."+searchKeyword.val());
		var formTag = $('form .form-search');
		formTag.attr("action","/search/searchResult.json"); // ?searchKeyword="+searchKeyword.val()
		formTag.submit();
	});
	
	// mouseenter, mouseleave
	searchInput.mouseenter(function(){
		searchInput.val('�˻��� Ű���带 �־��ּ���!');
	});
	
    searchInput.mouseleave(function(){
    	searchInput.val('');  // empty()�� �ȸ���;;
    	//$('#searchInput').val('�˻��� Ű���带 �־��ּ���!');
	});
    
    
    // focus, blur
    searchInput.focus(function(){
    	searchInput.val(''); // empty();
    });
    
    
    var studyDevBtn = $('div ul');
	//study.find('#studyDev').hide();
	studyDevBtn.find('#studyDev').click(function(){
		$('.tabbable').hide();
		studyPanel.show();
	});
    
    
});

// ����� �̺�Ʈ �׽�Ʈ 
/*window.onload=function(){
   var sBtn = window.document.getElementById("searchBtn");
   sBtn.addEventListener("click", function(e){
	   // 1. �̺�Ʈ ����
	   var myEvent = document.createEvent("Event");

	   // 2. �̺�Ʈ ��ü�� �̺�Ʈ�� �Բ� ��� ���� ������ ��
	   myEvent.data1 ="Sorry Not yet..Support! �˻��� ��� �˻��������� �� ���� �Դϴ�!";

	   // 3. �̺�Ʈ �ʱ�ȭ
	   myEvent.initEvent("myEvent", false, false);

	   // 4. �̺�Ʈ �߻�
	   sBtn.dispatchEvent(myEvent);	   
   });
   
   sBtn.addEventListener("myEvent", function(e){
       alert("�˻���..!, target ="+e.target.id+", data1 ="+e.data1);

    });
}*/