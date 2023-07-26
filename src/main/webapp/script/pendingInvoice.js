var table;
var rows_selected = [];
var selectedInvoiceNo = [];

$('document').ready(function() {

	getPendingInvoiceList('', '');

	$(document).on('shown.bs.modal', '#invoiceDetailsModal', function() {
		//      $('#invoiceDataTable').DataTable().ajax.reload();
		$(this).trigger('resize')
	});
	$('#select-all').on('click', function(e) {
		if (this.checked) {
			$('#invoiceDataTable tbody input[type="checkbox"]:not(:checked)').trigger('click');
		} else {
			$('#invoiceDataTable tbody input[type="checkbox"]:checked').trigger('click');
		}

		e.stopPropagation();
	});

	// Handle table draw event
	table.on('draw', function() {
		// Update state of "Select all" control
		updateDataTableSelectAllCtrl(table);
	});


	$('#fromDate').daterangepicker({
		locale: {
			format: 'DD/MM/YYYY'
		}
	});

	$('#fromDate').on('apply.daterangepicker', function(ev, picker) {
		rows_selected = [];
		selectedInvoiceNo = [];
		getPendingInvoiceList(picker.startDate.format('DD/MM/YYYY'), picker.endDate.format('DD/MM/YYYY'));

		$('#select-all').on('click', function(e) {
			if (this.checked) {
				$('#invoiceDataTable tbody input[type="checkbox"]:not(:checked)').trigger('click');
			} else {
				$('#invoiceDataTable tbody input[type="checkbox"]:checked').trigger('click');
			}

			e.stopPropagation();
		});

	});


	$('#invoiceDataTable tbody').on('click', 'input[type="checkbox"]', function(e) {
		var row = $(this).closest('tr');

		// Get row data
		var data = table.row(row).data();

		// Get row ID
		var rowId = data.salesInvoiceId;

		// Determine whether row ID is in the list of selected row IDs 
		var index = $.inArray(rowId, rows_selected);

		// If checkbox is checked and row ID is not in list of selected row IDs
		if (this.checked && index === -1) {
			rows_selected.push(rowId);
			selectedInvoiceNo.push(data.salesInvoiceNo);
			// Otherwise, if checkbox is not checked and row ID is in list of selected row IDs
		} else if (!this.checked && index !== -1) {
			rows_selected.splice(index, 1);
			selectedInvoiceNo.splice(index, 1);
		}

		if (this.checked) {
			row.addClass('selected');
		} else {
			row.removeClass('selected');
		}

		// Update state of "Select all" control
		updateDataTableSelectAllCtrl(table);

		// Prevent click event from propagating to parent
		e.stopPropagation();
	});
});

function closeInvoiceDetailsDiv() {
	$('#pendingInvoiceDiv').show();
	$('#pendingInvoiceLineDiv').hide();
}
function getPendingInvoiceList(startDate, endDate) {
	table = $('#invoiceDataTable').DataTable({
		ordering: false,
		destroy: true,
		searching: true,
		scrollY: true,
		scrollX: true,
		scrollCollapse: true,
		processing: true,
		serverSide: true,
		deferRender: true,
		responsive: true,
		async: true,
		//		width:"100%",
		ajax: {
			url: 'getPendingInvoiceList',
			data: {
				"startDate": startDate,
				"endDate": endDate
			}
		},

		columns: [
			{ title: '<input name="select_all" value="1" id="select-all" type="checkbox"  />' },
			{ title: 'Invoice No', data: 'salesInvoiceNo' },
			{ title: 'Invoice Type', data: 'salesInvoiceType' },
			{ title: 'Invoice Date', data: 'salesInvoiceDate' },
			{ title: 'Invoice Name', data: 'custFName' },
			{ title: 'Invoice GST No', data: 'custGSTNo' },
			{ title: 'Invoice Amount', data: 'total' },
		],
		createdRow: function(row, data, dataIndex) {
			if (data.downloaded === 'Y') {
				$(row).addClass('bg-light-danger');
			}
		},
		columnDefs: [
			{
				'processing': true,
				'serverSide': true,
				'targets': 0,
				'searchable': false,
				'orderable': false,
				'className': 'dt-body-center',
				'render': function(data, type, full, meta) {
					return '<input type="checkbox" name="id[]" value="'
						+ $('<div/>').text(data).html() + '">';
				}
			}],
		select: {
			style: 'multi',
		},
		order: [[1, 'asc']],
		'rowCallback': function(row, data, dataIndex) {
			// Get row ID
			var rowId = data.salesInvoiceId;

			if ($.inArray(rowId, rows_selected) !== -1) {
				$(row).find('input[type="checkbox"]').prop('checked', true);
				$(row).addClass('selected');
			}

		}
	});
}


function jsonPrepareFormatter(cellvalue, options, rowObject) {
	return "<a onclick='downloadJsonByInvoice(\"" + rowObject.salesInvoiceId + "\",\"" + rowObject.salesInvoiceNo + "\");' title='JSON Prepare' href='javascript:void(0)' class='btn btn-sm btn-light-info btn-hover-light-info btn-icon mr-2 my-1 my-lg-0' > <i class='fa fa-download'></i></a>";
}

function downloadJsonByInvoice(salesInvoiceId, salesInvoiceNo) {
	var link = document.createElement('a');

	document.body.appendChild(link);
	link.click();
}


function getPendingInvoiceDetails(salesInvoiceId, salesInvoiceNo) {
	var hrefLink = "getPrepareJsonFileInvoice?salesInvoiceId=" + salesInvoiceId + "&salesInvoiceNo=" + salesInvoiceNo;
	$("#downloadJSON").attr("href", hrefLink);

	$('#invoiceDetailDataTable').DataTable({
		ordering: false,
		destroy: true,
		searching: false,
		scrollY: true,
		scrollX: true,
		scrollCollapse: true,
		processing: true,
		serverSide: true,
		deferRender: true,
		responsive: true,
		async: true,
		lengthMenu: [5, 10, 25, 50],
		ajax: {
			url: 'getPendingInvoiceItemList/' + salesInvoiceId,
		},
		columns: [
			{ title: 'Product Description', data: 'PrdDesc' },
			{ title: 'Is Service', data: 'IsServc', render: formattorIsService },
			{ title: 'HSN Code', data: 'HsnCd' },
			{ title: 'Barcode', data: 'Barcde' },
			{ title: 'Quantity', data: 'Qty' },
			{ title: 'Free Quantity', data: 'FreeQty' },
			{ title: 'Unit', data: 'Unit' },
			{ title: 'Unit Price', data: 'UnitPrice' },
			{ title: 'Total Amount', data: 'TotAmt' },
			{ title: 'Discount', data: 'Discount' },
			{ title: 'Assessable Amount', data: 'AssAmt' },
			{ title: 'GST Rate', data: 'GstRt' },
			{ title: 'Igst Amount', data: 'IgstAmt' },
			{ title: 'Cgst Amount', data: 'CgstAmt' },
			{ title: 'Sgst Amount', data: 'SgstAmt' },
			{ title: 'Total Item Value', data: 'TotItemVal' },
		],
	});
}

function formattorIsService(cellvalue, options, rowObject) {
	if (rowObject.IsServc === "1") {
		return "Y";
	} else {
		return "N";
	}
}


function updateDataTableSelectAllCtrl(table) {
	var $table = table.table().node();
	var $chkbox_all = $('tbody input[type="checkbox"]', $table);
	var $chkbox_checked = $('tbody input[type="checkbox"]:checked', $table);
	var chkbox_select_all = $('thead input[name="select_all"]', $table).get(0);

	// If none of the checkboxes are checked
	if ($chkbox_checked.length === 0) {
		chkbox_select_all.checked = false;
		if ('indeterminate' in chkbox_select_all) {
			chkbox_select_all.indeterminate = false;
		}

		// If all of the checkboxes are checked
	} else if ($chkbox_checked.length === $chkbox_all.length) {
		chkbox_select_all.checked = true;
		if ('indeterminate' in chkbox_select_all) {
			chkbox_select_all.indeterminate = false;
		}

		// If some of the checkboxes are checked
	} else {
		chkbox_select_all.checked = true;
		if ('indeterminate' in chkbox_select_all) {
			chkbox_select_all.indeterminate = true;
		}
	}
}


function downloadMultipleJson() {

	if (rows_selected.length == 0) {
		alert('Kindly select atleat one invoice to download!');
		return;
	}
		$.ajax({
			url: 'validatePendingInvoiceList',
			type: "POST",
			async:false,
			data: {
				"invoiceId[]": rows_selected,
			},
			success:function(data){
				if(data !== 'Done'){
					alert(data);
				}else{
					jQuery('<form action="getPrepareJsonFileInvoice" method="GET" target="_blank">'
					+ '<input type="text" name="invoiceId[]" value="' + rows_selected + '">'
					+ '<input type="text" name="invoiceNo[]" value="' + selectedInvoiceNo + '">'
					+ '</form>').appendTo('body').submit().remove();
				}
			},error:function(data){
				alert(data.responseText);
			}
		});
	

}