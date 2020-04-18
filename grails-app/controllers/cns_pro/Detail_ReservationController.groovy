package cns_pro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Detail_ReservationController {

    Detail_ReservationService detail_ReservationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond detail_ReservationService.list(params), model:[detail_ReservationCount: detail_ReservationService.count()]
    }

    def show(Long id) {
        respond detail_ReservationService.get(id)
    }

    def create() {
        respond new Detail_Reservation(params)
    }

    def save(Detail_Reservation detail_Reservation) {
        if (detail_Reservation == null) {
            notFound()
            return
        }

        try {
            detail_ReservationService.save(detail_Reservation)
        } catch (ValidationException e) {
            respond detail_Reservation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'detail_Reservation.label', default: 'Detail_Reservation'), detail_Reservation.id])
                redirect detail_Reservation
            }
            '*' { respond detail_Reservation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond detail_ReservationService.get(id)
    }

    def update(Detail_Reservation detail_Reservation) {
        if (detail_Reservation == null) {
            notFound()
            return
        }

        try {
            detail_ReservationService.save(detail_Reservation)
        } catch (ValidationException e) {
            respond detail_Reservation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'detail_Reservation.label', default: 'Detail_Reservation'), detail_Reservation.id])
                redirect detail_Reservation
            }
            '*'{ respond detail_Reservation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        detail_ReservationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'detail_Reservation.label', default: 'Detail_Reservation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'detail_Reservation.label', default: 'Detail_Reservation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
