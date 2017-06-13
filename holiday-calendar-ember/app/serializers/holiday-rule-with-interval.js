import ApplicationSerializer from './application';

export default ApplicationSerializer.extend(DS.EmbeddedRecordsMixin, {
  attrs: {
    interval: {
      embedded: 'always'
    },
    holidayRule: {
      embedded: 'always'
    }
  }
})
