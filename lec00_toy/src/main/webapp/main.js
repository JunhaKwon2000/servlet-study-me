/**
 * 
 */

// 캘린더
$(document).ready(() => {
	
	const calendarDiv = $('#calendar')[0];
	const calendar = new FullCalendar.Calendar(calendarDiv, {
		
		initialView: 'dayGridWeek',
		locale: 'ko',
		events: [
			{
				title: '수학 인강 듣기',
				start: '2025-06-28'
			},
			{
				title: '수능 완성 국어 4단원 풀기',
				start: '2025-06-28'
			}
			
		]
		
	});
	calendar.render();
	
	
});