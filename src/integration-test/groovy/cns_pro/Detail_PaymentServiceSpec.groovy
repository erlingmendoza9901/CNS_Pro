package cns_pro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Detail_PaymentServiceSpec extends Specification {

    Detail_PaymentService detail_PaymentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Detail_Payment(...).save(flush: true, failOnError: true)
        //new Detail_Payment(...).save(flush: true, failOnError: true)
        //Detail_Payment detail_Payment = new Detail_Payment(...).save(flush: true, failOnError: true)
        //new Detail_Payment(...).save(flush: true, failOnError: true)
        //new Detail_Payment(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //detail_Payment.id
    }

    void "test get"() {
        setupData()

        expect:
        detail_PaymentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Detail_Payment> detail_PaymentList = detail_PaymentService.list(max: 2, offset: 2)

        then:
        detail_PaymentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        detail_PaymentService.count() == 5
    }

    void "test delete"() {
        Long detail_PaymentId = setupData()

        expect:
        detail_PaymentService.count() == 5

        when:
        detail_PaymentService.delete(detail_PaymentId)
        sessionFactory.currentSession.flush()

        then:
        detail_PaymentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Detail_Payment detail_Payment = new Detail_Payment()
        detail_PaymentService.save(detail_Payment)

        then:
        detail_Payment.id != null
    }
}
