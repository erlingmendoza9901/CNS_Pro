package cns_pro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Detail_PaymentController {

    Detail_PaymentService detail_PaymentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond detail_PaymentService.list(params), model:[detail_PaymentCount: detail_PaymentService.count()]
    }

    def show(Long id) {
        respond detail_PaymentService.get(id)
    }

    def create() {
        respond new Detail_Payment(params)
    }

    def save(Detail_Payment detail_Payment) {
        if (detail_Payment == null) {
            notFound()
            return
        }

        try {
            detail_PaymentService.save(detail_Payment)
        } catch (ValidationException e) {
            respond detail_Payment.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'detail_Payment.label', default: 'Detail_Payment'), detail_Payment.id])
                redirect detail_Payment
            }
            '*' { respond detail_Payment, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond detail_PaymentService.get(id)
    }

    def update(Detail_Payment detail_Payment) {
        if (detail_Payment == null) {
            notFound()
            return
        }

        try {
            detail_PaymentService.save(detail_Payment)
        } catch (ValidationException e) {
            respond detail_Payment.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'detail_Payment.label', default: 'Detail_Payment'), detail_Payment.id])
                redirect detail_Payment
            }
            '*'{ respond detail_Payment, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        detail_PaymentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'detail_Payment.label', default: 'Detail_Payment'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'detail_Payment.label', default: 'Detail_Payment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
