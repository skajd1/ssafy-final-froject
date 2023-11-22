import { ref, reactive, computed, watch } from "vue";
import { defineStore } from "pinia";
import { getTripInfoById } from "@/api/TripApi.js";
import { getTripInfo } from "@/api/TripApi.js";

const useTripStore = defineStore("useTripStore", () => {
  const tripItems = ref([]);
  const selectedTrip = ref({});

  const initTripItems = () => {
    tripItems.value = [];
  };

  const getTripItems = (cid) => {
    getTripInfoById(
      cid,
      (res) => {
        tripItems.value.push(res.data[0]);
      },
      (err) => {
        console.log(err);
      }
    );
  };

  const select = (trip) => {
    selectedTrip.value = trip;
  };
  const items = computed(() => tripItems.value);
  const selected = computed(() => selectedTrip.value);

  // 여행지 조회
  const tripList = reactive([]);
  const searchdata = reactive({
    keyword: "",
    sido: "",
    gugun: "",
  });
  const themelist = reactive([]);

  const keyword = computed({
    get: () => searchdata.keyword,
    set: (value) => (searchdata.keyword = value),
  });

  const sido = computed({
    get: () => searchdata.sido,
    set: (value) => (searchdata.sido = value),
  });

  const gugun = computed({
    get: () => searchdata.gugun,
    set: (value) => (searchdata.gugun = value),
  });

  const theme = computed({
    get: () => themelist.value,
    set: (value) => (themelist.value = value),
  });

  const getTripList = () => {
    getTripInfo(
      searchdata,
      (res) => {
        tripList.value = res.data;
      },
      (err) => {
        console.log(err);
      }
    );
  };

  const lists = computed(() => tripList.value);
  const searchData = computed(() => searchdata);

  return {
    initTripItems,
    getTripItems,
    getTripList,
    select,
    items,
    selected,
    searchData,
    keyword,
    sido,
    gugun,
    themelist,
    theme,
    lists,
  };
});

export { useTripStore };
