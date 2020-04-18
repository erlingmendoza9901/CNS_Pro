package cns_pro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Detail_ReservationServiceSpec extends Specification {

    Detail_ReservationService detail_ReservationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Detail_Reservation(...).save(flush: true, failOnError: true)
        //new Detail_Reservation(...).save(flush: true, failOnError: true)
        //Detail_Reservation detail_Reservation = new Detail_Reservation(...).save(flush: true, failOnError: true)
        //new Detail_Reservation(...).save(flush: true, failOnError: true)
        //new Detail_Reservation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //detail_Reservation.id
    }

    void "test get"() {
        setupData()

        expect:
        detail_ReservationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Detail_Reservation> detail_ReservationList = detail_ReservationService.list(max: 2, offset: 2)

        then:
        detail_ReservationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        detail_ReservationService.count() == 5
    }

    void "test delete"() {
        Long detail_ReservationId = setupData()

        expect:
        detail_ReservationService.count() == 5

        when:
        detail_ReservationService.delete(detail_ReservationId)
        sessionFactory.currentSession.flush()

        then:
        detail_ReservationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Detail_Reservation detail_Reservation = new Detail_Reservation()
        detail_ReservationService.save(detail_Reservation)

        then:
        detail_Reservation.id != null
    }
}
