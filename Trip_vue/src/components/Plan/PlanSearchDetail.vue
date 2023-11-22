<script setup>
import { ref, watch, onMounted, reactive } from "vue";
import { storeToRefs } from "pinia";
import { getGugun, getSido } from "@/api/TripApi.js";
import { useTripStore } from "@/stores/tripStore";

const tripStore = useTripStore();
const { sido, gugun, theme, lists } = storeToRefs(tripStore);

const chooseSido = ref("");
const chooseGugun = ref("");
const chooseTheme = ref([]);
const gugunlist = ref([]);
const sidolist = ref([]);

watch(chooseSido, () => {
  //sido 코드가 변할 때 마다 비동기로 gugun 리스트 가져와서 gugun 리스트에 저장
  getGugun(
    chooseSido.value,
    (res) => {
      chooseGugun.value = "";
      gugunlist.value = res.data;
    },
    (e) => {
      console.log(e);
    }
  );
});

onMounted(() => {
  getSido(
    (res) => {
      sidolist.value = res.data;
    },
    (error) => {
      console.log(error);
    }
  );
});

const themelist = ref([
  { themeCode: "12", themeName: "관광지" },
  { themeCode: "14", themeName: "문화시설" },
  { themeCode: "15", themeName: "축제공연행사" },
  { themeCode: "25", themeName: "여행코스" },
  { themeCode: "28", themeName: "레포츠" },
  { themeCode: "32", themeName: "숙박" },
  { themeCode: "38", themeName: "쇼핑" },
  { themeCode: "39", themeName: "음식점" },
]);

watch(chooseSido, () => {
  sido.value = chooseSido.value;
});

watch(chooseGugun, () => {
  gugun.value = chooseGugun.value;
});

function selectTheme(themeCode) {
  if (chooseTheme.value.includes(themeCode)) {
    chooseTheme.value = chooseTheme.value.filter((item) => item !== themeCode);
  } else {
    chooseTheme.value.push(themeCode);
  }
}

watch(
  chooseTheme,
  () => {
    theme.value = chooseTheme.value;
  },
  { deep: true }
);

// function search() {
//   if (chooseSido.value === "") {
//     alert("시/도를 선택하세요");
//     return;
//   }
//   if (chooseGugun.value === "") {
//     alert("구/군을 선택하세요");
//     return;
//   }
//   if (chooseThema.value.length === 0) {
//     alert("테마를 선택하세요");
//     return;
//   }
//   console.log(chooseSido.value);
//   console.log(chooseGugun.value);
//   console.log(chooseThema.value);

//   // 시도, 구군, 테마 코드에 맞는 관광지 리스트 가져오기
//   // -> keyword는 null이여도 그냥 ''로 넘겨도 된다.
//   // null이 아니면 where절에 동적 쿼리로 추가하기.

//   sido.value = chooseSido.value;
//   gugun.value = chooseGugun.value;
//   thema.value = chooseThema.value;

//   getTripList();
// }
</script>

<template>
  <div>
    <div class="container">
      <slot></slot>
      <form id="form1" class="form-horizontal">
        <div class="form-group" id="location">
          <div class="form-search">
            <!-- <label for="sido"> 시/도 : </label> -->
            <select class="form-control" id="sido" v-model="chooseSido">
              <option value="" selected disabled>시/도 선택</option>
              <option v-for="sido in sidolist" :key="sido.sido_code" :value="sido.sido_code">
                {{ sido.sido_name }}
              </option>
            </select>
          </div>
          <div class="form-search">
            <!-- <label for="gugun"> 구/군 선택 : </label> -->
            <select class="form-control" id="gugun" v-model="chooseGugun">
              <option value="" selected disabled>구/군 선택</option>
              <option v-for="gugun in gugunlist" :key="gugun.gugun_code" :value="gugun.gugun_code">
                {{ gugun.gugun_name }}
              </option>
            </select>
          </div>
        </div>

        <div class="form-group theme">
          <!-- checkbox -->
          <span v-for="(theme, index) in themelist" :key="theme.themeCode">
            <input
              type="checkbox"
              :name="theme.themeCode"
              :value="theme.themeCode"
              @click="selectTheme(theme.themeCode)"
              v-bind:disabled="lists == null"
            />

            <label :for="theme.themeCode">{{ theme.themeName }}</label>
          </span>
        </div>

        <!-- <div class="btn-group">
          <input type="button" value="검색" id="btnInsert" @click="search()" />
          <input type="reset" value="초기화" id="btnInit" />
        </div> -->
      </form>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.theme {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  margin-bottom: 20px;
}
.container {
  width: 100%;
  margin: 0 auto;
}

.btn-group {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  margin-bottom: 20px;

  input {
    width: 120px;
    height: 35px;
    border-radius: 10px;
    border: none;
    background-color: var(--main-color);
  }
}

#location {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin-top: 20px;
  .form-search {
    width: 150px;
    margin: 10px;
  }
}
</style>
