$(document)
		.ready(
				function() {
					$('#friendsList_followBtn')
							.on(
									'click',
									function() {
										// $('#friendsList_followBtn').css('color',
										// 'red');
										if ($('#friendsList_followBtn').attr(
												'value') == "+팔로우") {
											// $('#friendsList_followBtn').css('background',
											// '#b9e356');
											$('#friendsList_followBtn')
													.val('✔팔로잉')
													.css(
															{
																'-moz-box-shadow' : 'inset 0px 1px 0px 0px #d9fbbe',
																'-webkit-box-shadow' : 'inset 0px 1px 0px 0px #d9fbbe',
																'box-shadow' : 'inset 0px 1px 0px 0px #d9fbbe',
																'background' : '-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #b8e356), color-stop(1, #a5cc52))',
																'background' : '-moz-linear-gradient(top, #b8e356 5%, #a5cc52 100%)',
																'background' : '-webkit-linear-gradient(top, #b8e356 5%, #a5cc52 100%)',
																'background' : '-o-linear-gradient(top, #b8e356 5%, #a5cc52 100%)',
																'background' : '-ms-linear-gradient(top, #b8e356 5%, #a5cc52 100%)',
																'background' : 'linear-gradient(to bottom, #b8e356 5%, #a5cc52 100%)',
																'filter' : 'progid:DXImageTransform.Microsoft.gradient(startColorstr="#b8e356", endColorstr="#a5cc52",GradientType=0)',
																'background-color' : '#b8e356',
																'-moz-border-radius' : '6px',
																'-webkit-border-radius' : '6px',
																'border-radius' : '6px',
																'border' : '1px solid #83c41a',
																'display' : 'inline-block',
																'cursor' : 'pointer',
																'color' : '#ffffff',
																'font-family' : 'Arial',
																'font-size' : '15px',
																'font-weight' : 'bold',
																'padding' : '6px 24px',
																'text-decoration' : 'none',
																'text-shadow' : '0px 1px 0px #86ae47'
															});
										} else {
											// $('#friendsList_followBtn').css('background',
											// '#bbdaf7');
											$('#friendsList_followBtn')
													.val('+팔로우')
													.css(
															{
																'-moz-box-shadow' : 'inset 0px 1px 0px 0px #bbdaf7',
																'-webkit-box-shadow' : 'inset 0px 1px 0px 0px #bbdaf7',
																'box-shadow' : 'inset 0px 1px 0px 0px #bbdaf7',
																'background' : '-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #79bbff), color-stop(1, #378de5))',
																'background' : '-moz-linear-gradient(top, #79bbff 5%, #378de5 100%)',
																'background' : '-webkit-linear-gradient(top, #79bbff 5%, #378de5 100%)',
																'background' : '-o-linear-gradient(top, #79bbff 5%, #378de5 100%)',
																'background' : '-ms-linear-gradient(top, #79bbff 5%, #378de5 100%)',
																'background' : 'linear-gradient(to bottom, #79bbff 5%, #378de5 100%)',
																'filter' : 'progid:DXImageTransform.Microsoft.gradient(startColorstr="#79bbff", endColorstr="#378de5",GradientType=0)',
																'background-color' : '#79bbff',
																'-moz-border-radius' : '6px',
																'-webkit-border-radius' : '6px',
																'border-radius' : '6px',
																'border' : '1px solid #84bbf3',
																'display' : 'inline-block',
																'cursor' : 'pointer',
																'color' : '#ffffff',
																'font-family' : 'Arial',
																'font-size' : '15px',
																'font-weight' : 'bold',
																'padding' : '6px 24px',
																'text-decoration' : 'none',
																'text-shadow' : '0px 1px 0px #528ecc'

															});
										}

									})
				});

function followBtn(obj) {

}

/*
 * .myButton { -moz-box-shadow:inset 0px 1px 0px 0px #d9fbbe;
 * -webkit-box-shadow:inset 0px 1px 0px 0px #d9fbbe; box-shadow:inset 0px 1px
 * 0px 0px #d9fbbe; background:-webkit-gradient(linear, left top, left bottom,
 * color-stop(0.05, #b8e356), color-stop(1, #a5cc52));
 * background:-moz-linear-gradient(top, #b8e356 5%, #a5cc52 100%);
 * background:-webkit-linear-gradient(top, #b8e356 5%, #a5cc52 100%);
 * background:-o-linear-gradient(top, #b8e356 5%, #a5cc52 100%);
 * background:-ms-linear-gradient(top, #b8e356 5%, #a5cc52 100%);
 * background:linear-gradient(to bottom, #b8e356 5%, #a5cc52 100%);
 * filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#b8e356',
 * endColorstr='#a5cc52',GradientType=0); background-color:#b8e356;
 * -moz-border-radius:6px; -webkit-border-radius:6px; border-radius:6px;
 * border:1px solid #83c41a; display:inline-block; cursor:pointer;
 * color:#ffffff; font-family:Arial; font-size:15px; font-weight:bold;
 * padding:6px 24px; text-decoration:none; text-shadow:0px 1px 0px #86ae47; }
 * .myButton:hover { background:-webkit-gradient(linear, left top, left bottom,
 * color-stop(0.05, #a5cc52), color-stop(1, #b8e356));
 * background:-moz-linear-gradient(top, #a5cc52 5%, #b8e356 100%);
 * background:-webkit-linear-gradient(top, #a5cc52 5%, #b8e356 100%);
 * background:-o-linear-gradient(top, #a5cc52 5%, #b8e356 100%);
 * background:-ms-linear-gradient(top, #a5cc52 5%, #b8e356 100%);
 * background:linear-gradient(to bottom, #a5cc52 5%, #b8e356 100%);
 * filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#a5cc52',
 * endColorstr='#b8e356',GradientType=0); background-color:#a5cc52; }
 * .myButton:active { position:relative; top:1px; }
 * 
 */
