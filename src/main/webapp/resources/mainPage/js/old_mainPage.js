
/* jquery study~~~ */
$(document).ready(function(){
	$('#study').css('background','pink');
	$('#develop').css('background','yellow');
	$('#result').css('background','skyblue');
	//$('body ul #notice').hide();
	//var home = $('div ul');
	//home.find('#fCome').hide();
	//$('.tab-pane').hide();
	$('.carousel-inner #img1').width('1050px');
	$('.carousel-inner #img1').height('350px');
	
	$('.carousel-inner #img2').width('1050px');
	$('.carousel-inner #img2').height('450px');
	
	$('.carousel-inner #img3').width('1050px');
	$('.carousel-inner #img3').height('550px');
	
	/* facebookLink */
	//$('#facebookLink').fadeIn();
	//$('#facebookLink').slideDown();
	$('#facebookLink').slideDown();
	
	$('#div1').animate({
		top: 300,
		left: 300
		
	},1000);
	
	$('#div1').slideUp(2000);
	
	//$('#div1').text('����? NO!, ������? NO!!'); // �ؽ�Ʈ�� ��ü! html()�� �ִ�!
	//$('#div1').empty();  // div�� ���������� �ؽ�Ʈ�� �������.
	
	//$('.carousel-inner #attrTest').attr('src', 'resources/img/acet.png'); // ����� �Ӽ����� �����ϴ� �޼ҵ�!
	//$('#searchInput').val('�˻��� Ű���带 �־��ּ���!');
	$('#searchInput').width('20em');
	
	/* <span class="label label-success">Step 01.</span> */
	//$('.label').removeClass('label-success'); // ���� ���� �������� class�� ��� ����! addClass()�� ����!

	/***** EVENT ******/
	// click
	$('#searchBtn').click(function(){
		//$('#searchInput').empty();
		alert("click �Ǿ����ϴ�.");
	});
	
	// mouseenter, mouseleave
	$('#searchInput').mouseenter(function(){
		$('#searchInput').val('�˻��� Ű���带 �־��ּ���!');
	});
	
    $('#searchInput').mouseleave(function(){
    	$('#searchInput').val('');  // empty()�� �ȸ���;;
    	//$('#searchInput').val('�˻��� Ű���带 �־��ּ���!');
	});
    
    
    // focus, blur
    $('#searchInput').focus(function(){
    	$('#searchInput').val(''); // empty();
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